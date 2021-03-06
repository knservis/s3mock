package io.findify.s3mock.awscli

import akka.http.scaladsl.model.{HttpMethods, HttpRequest}
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.collection.JavaConversions._

/**
  * Created by shutty on 8/28/16.
  */
class PutBucketTest extends AWSCliTest {
  "awscli mb" should "create bucket" in {
    val response = Await.result(http.singleRequest(HttpRequest(method = HttpMethods.PUT, uri = "http://127.0.0.1:8001/awscli")), 10.seconds)
    s3.listBuckets().exists(_.getName == "awscli") shouldBe true
  }
}
