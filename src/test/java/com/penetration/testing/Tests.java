package com.penetration.testing;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Tests {


@Test
    public void testZero() throws IOException, InterruptedException {
        System.out.println("=======================================================================================================================================");
        System.out.println("=======================================================================================================================================");
        String s;
        Process p;
            p = Runtime.getRuntime().exec("ls -aF");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
    }


}