package com.goos.sniper

import java.util.concurrent.{ArrayBlockingQueue, TimeUnit}
import TimeUnit.SECONDS

import org.junit._
import org.junit.Assert._
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers._

import org.jivesoftware.smack.packet.Message
import org.jivesoftware.smack._

class FakeAuctionServer(val itemId: String) {
  val ITEM_ID_AS_LOGIN = "auction-%s"
  val AUCTION_RESOURCE = "Auction"
  val XMPP_HOSTNAME = "localhost"

  private val AUCTION_PASSWORD = "auction"
  private val connection = new XMPPConnection(XMPP_HOSTNAME)
  
  var currentChat: Chat = null

  private val messageListener = new SingleMessageListener();

  @throws[XMPPException]
  def startSellingItem()  {
    connection.connect()
    connection.login(
      String.format(ITEM_ID_AS_LOGIN, itemId),
      AUCTION_PASSWORD, 
      AUCTION_RESOURCE
    )

    connection.getChatManager().addChatListener(
      new ChatManagerListener {
        def chatCreated(chat: Chat, createdLocally: Boolean) {
          currentChat = chat;
        }
      }
    )
  }
  
  def getItemId(): String = {
    itemId
  }

  @throws[InterruptedException]
  def hasReceivedJoinRequestFromSniper() {
    messageListener.receivesAMessage();
  }

  @throws[XMPPException]
  def announceClosed() {
    currentChat.sendMessage(new Message());
  }

  def stop() {
    connection.disconnect();
  }

  class SingleMessageListener extends MessageListener {
    val messages = new ArrayBlockingQueue[Message](1);
    def processMessage(chat: Chat, message: Message) {
      messages.add(message);
    }

    @throws[InterruptedException]
    def receivesAMessage() {
      assertThat("Message", messages.poll(5, SECONDS), is(notNullValue()));
    }
  }
}
