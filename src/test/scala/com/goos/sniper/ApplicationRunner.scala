package com.goos.sniper

class ApplicationRunner {

  val SNIPER_ID = "sniper"
  val SNIPER_PASSWORD = "sniper"
  val XMPP_HOSTNAME = "localhost"
  val SNIPER_XMPP_ID = SNIPER_ID + "@" + XMPP_HOSTNAME + "/Auction"

  val STATUS_JOINING = "Joinning"
  val STATUS_LOST = "Lost"

  var driver: AuctionSniperDriver = null

  def startBiddingIn(auction: FakeAuctionServer) {
    val thread = new Thread("Test Application") {
      override def run() {
        try {
          new Main(XMPP_HOSTNAME, SNIPER_ID, SNIPER_PASSWORD, auction.getItemId());
        } catch {
          case e: Exception => e.printStackTrace();
        }
      }
    };

    thread.setDaemon(true);
    thread.start();
    driver = new AuctionSniperDriver(1000);
    driver.showsSniperStatus(STATUS_JOINING);
  }

  def showsSniperHasLostAuction() {
    driver.showsSniperStatus(STATUS_LOST);
  }

  def stop() {
    if (driver != null) {
      driver.dispose();
    }
  }
}