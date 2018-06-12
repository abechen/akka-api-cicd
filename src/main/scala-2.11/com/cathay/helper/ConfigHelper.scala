package com.cathay.helper

import java.io.File

import com.typesafe.config.ConfigFactory


trait ConfigHelper {

  private val conPath = "conf/api.conf"
  private val config = ConfigFactory.parseFile(
    new File(s"${System.getProperty("user.dir")}/${conPath}"))

  lazy val env = config.getString("env")
  lazy val apiHost = config.getString("api.host")
  lazy val apiPort = config.getInt("api.port")

}