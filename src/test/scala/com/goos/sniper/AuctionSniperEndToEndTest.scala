package com.goos.sniper;

import org.junit.Assert._
import org.junit.Test
import org.junit.After

class AuctionSniperEndToEndTest {
  val auction = new FakeAuctionServer("item-54321");
  val application = new ApplicationRunner();

  @Test
  @throws(classOf[Exception])
  def sniperJoinsAuctionUntilAuctionCloses() {
    auction.startSellingItem(); // Step 1
    application.startBiddingIn(auction); // Step 2
    auction.hasReceivedJoinRequestFromSniper(); // Step 3
    auction.announceClosed(); // Step 4
    application.showsSniperHasLostAuction(); // Step 5
  }

  // Additional cleanup
  @After
  def stopAuction() {
    auction.stop();
  }

  @After
  def stopApplication() {
    application.stop();
  }
}