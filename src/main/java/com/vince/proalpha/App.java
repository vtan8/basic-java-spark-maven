package com.vince.proalpha;

import spark.Spark;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      if (args.length < 4) {
        System.err.println("Usage: LEDGER_HOST LEDGER_PORT PARTY REST_PORT");
      }
      int restport = Integer.valueOf(args[3]);
      System.out.println( "Main app listening at port " + args[3] );
      Spark.port(restport);

      //Spark.get("/iou", "application/json", (req, res) -> g.toJson(contracts));
      Spark.get("/hello", (req, res) -> "Hello world, " + args[2]);
    }
}
