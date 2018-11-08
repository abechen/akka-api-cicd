package com.cathay.helper

import java.io.File
import java.lang.management.ManagementFactory

import com.typesafe.config.ConfigFactory


trait ConfigHelper {

  private val conPath = ManagementFactory.getRuntimeMXBean().getInputArguments().size() match {
    case 0 => "conf/api.conf"
    case _ => "conf/dev/api.conf" // debug mode
  }

  private val conPath = "conf/api.conf"
  private val config = ConfigFactory.parseFile(
    new File(s"${System.getProperty("user.dir")}/${conPath}"))

  lazy val env = config.getString("env")
  lazy val apiHost = config.getString("api.host")
  lazy val apiPort = config.getInt("api.port")

}