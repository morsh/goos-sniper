package com.goos.sniper;

import java.awt.event.{WindowAdapter, WindowEvent}
import javax.swing.SwingUtilities

class Main(args: String*) {
  var ui: MainWindow = null

  startUserInterface()

  @throws[Exception]
  def main(args: String*) {
    val main = new Main()
  }

  @throws[Exception]
  def startUserInterface() {
    SwingUtilities.invokeAndWait(new Runnable {
      def run() {
        ui = new MainWindow();
      }
    });
  }
}

object Main {

  
  val SNIPERS_TABLE_NAME = "Snipers Table"
  val APP_TITLE = "Auction Sniper"
  val NEW_ITEM_ID_NAME = "new-item-id"
  val NEW_ITEM_STOP_PRICE_NAME = "new-item-stop-price"
  val JOIN_BUTTON_NAME = "join-button"
  val MAIN_WINDOW_NAME = "Auction Sniper"
  val SNIPER_STATUS_NAME = "sniper-status"
  
//   val ARG_HOSTNAME = 0
//   val ARG_USERNAME = 1
//   val ARG_PASSWORD = 2
}