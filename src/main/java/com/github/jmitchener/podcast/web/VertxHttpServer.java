package com.github.jmitchener.podcast.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

/**
 * Main HTTP server application
 */
public class VertxHttpServer {
    private static final Logger log = LoggerFactory.getLogger(VertxHttpServer.class);

    private static final int DEFAULT_HTTP_PORT = 9999;

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);
        router.route().handler(StaticHandler.create());

        router.route("/api/*").handler(routingContext -> {

            // This handler will be called for every request
            HttpServerResponse response = routingContext.response();
            response.putHeader("content-type", "text/plain");

            // Write to the response and end it
            response.end("Hello World from Vert.x-Web!");
        });

        router.route("/podcasts/*").handler(routingContext -> {

        });

        final int httpPort = getHttpPort();

        log.info("Starting HTTP Server on port " + httpPort);
        server.requestHandler(router::accept).listen(httpPort);
    }

    /**
     * Get the HTTP port from env or default.
     * @return The port to listen on for HTTP traffic
     */
    public static final int getHttpPort() {
        final String envHttpPort = System.getenv("JCM_PODCAST_HTTP_PORT");

        if (envHttpPort == null || envHttpPort.isEmpty()) {
            return DEFAULT_HTTP_PORT;
        } else {
            return Integer.parseInt(envHttpPort);
        }

    }
}
