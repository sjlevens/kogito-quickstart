package org.acme.kafka;

import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

import io.smallrye.reactive.messaging.annotations.Merge;

@ApplicationScoped
public class LogChild {

  private static final Logger LOG = Logger.getLogger(LogChild.class);

  @Incoming("child")
  @Merge
  public CompletionStage<Void> consume(Message<String> child) {
    LOG.info(child.getPayload());
    return child.ack();
  }
}
