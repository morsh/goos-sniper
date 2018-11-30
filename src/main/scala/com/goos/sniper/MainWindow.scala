package com.goos.sniper;

import javax.swing._

class MainWindow extends JFrame("Auction Sniper") {
  
  val MAIN_WINDOW_NAME = "Auction Sniper"

  setName(MAIN_WINDOW_NAME);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(true);
}

object MainWindow {
  val SNIPERS_TABLE_NAME = "Snipers Table"
  val APP_TITLE = "Auction Sniper"
  val NEW_ITEM_ID_NAME = "new-item-id"
  val NEW_ITEM_STOP_PRICE_NAME = "new-item-stop-price"
  val JOIN_BUTTON_NAME = "join-button"
  val MAIN_WINDOW_NAME = "Auction Sniper"
  val SNIPER_STATUS_NAME = "sniper-status"
}