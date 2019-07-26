package com.vince.proalpha;

import com.daml.ledger.rxjava.DamlLedgerClient;
import com.daml.ledger.rxjava.LedgerClient;
import com.daml.ledger.rxjava.PackageClient;
import spark.Spark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class App 
{
    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
      if (args.length < 4) {
        System.err.println("Usage: LEDGER_HOST LEDGER_PORT PARTY REST_PORT");
      }

      String ledgerhost = args[0];
      int ledgerport = Integer.valueOf(args[1]);
      String party = args[2];
      int restport = Integer.valueOf(args[3]);

      DamlLedgerClient client = DamlLedgerClient.forHostWithLedgerIdDiscovery(ledgerhost, ledgerport, Optional.empty());

      client.connect();

      String ledgerId = client.getLedgerId();

      logger.info("ledger-id: {}", ledgerId);

      System.out.println( "Main app listening at port " + args[3] );
      Spark.port(restport);

      //Spark.get("/iou", "application/json", (req, res) -> g.toJson(contracts));
      Spark.get("/hello", (req, res) -> "Hello world, " + args[2]);
    }
}
