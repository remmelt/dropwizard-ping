package com.remmelt.examples;

import com.remmelt.examples.health.PingHealthCheck;
import com.remmelt.examples.resources.PingResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.joda.time.DateTimeZone;

public class PingApplication extends Application<PingConfiguration> {
	public static void main(String[] args) throws Exception {
		new PingApplication().run(args);
	}

	@Override
	public String getName() {
		return "ping-app";
	}

	@Override
	public void initialize(Bootstrap<PingConfiguration> bootstrap) {
		DateTimeZone.setDefault(DateTimeZone.UTC);
	}

	@Override
	public void run(PingConfiguration configuration, Environment environment) throws Exception {
		environment.jersey().register(new PingResource());
		environment.healthChecks().register("Ping health check", new PingHealthCheck());
	}
}
