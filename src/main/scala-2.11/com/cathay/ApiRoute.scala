package com.cathay

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer


case class ApiRoute(actorSystem: ActorSystem, actorMaterializer: ActorMaterializer) {
  val route: Route =
    path("hello") {
      get {
        complete(200, "Hello Cathay !!")
      }
    }
}