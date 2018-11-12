package com.example

import akka.actor.Actor
import akka.event.Logging
import scala.collection.mutable.HashMap
import com.example.messages.SetRequest

class AkkademyDb extends Actor {
  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive = {
    case SetRequest(key, value) => {
      log.info("received SetRuquest - key: {} value: {}", key, value)
      map.put(key, value)
    }
    case o => log.info("received unknown message: {}", o);
  }
}