package com.cathay.helper

import org.apache.logging.log4j.{LogManager, Logger}
import org.apache.logging.log4j.core.config.ConfigurationSource
import org.apache.logging.log4j.core.config.Configurator

import java.io.FileInputStream

trait LogHelper {

  // load log config
  Configurator.initialize(null,
    new ConfigurationSource(
      new FileInputStream(s"${System.getProperty("user.dir")}/conf/log4j2.xml")))

  lazy val logger: Logger = LogManager.getLogger(getClass.getName)
}
