package com.cathay

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContextExecutor
import scala.util.{Failure, Success}

import com.cathay.helper.{LogHelper, ConfigHelper}


object ApiServer extends App with ConfigHelper {
  println(s"Env = ${env}")

  // Run api server
  new ApiServer("akka-api-cicd", host = apiHost, port = apiPort)
    .run
}

class ApiServer(name: String, host: String, port: Int) extends LogHelper {

  implicit val system: ActorSystem = ActorSystem(name)
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  def run: Unit = {
    val apiRoute = ApiRoute(system, materializer)

    val bindingFuture = Http().bindAndHandle(apiRoute.route, host, port)

    bindingFuture.onComplete {
      case Success(binding) =>
        logger.info(s"Server online at http://${host}:${port}/\n")
      case Failure(e) =>
        logger.error(s"Binding failed with ${e.getMessage}")
        system.terminate()
    }
  }
}