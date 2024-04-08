package com.pipi.xoj.sandbox;

import com.pipi.xoj.common.core.response.R;
import com.pipi.xoj.sandbox.service.RequestSandBoxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XojSandboxApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    RequestSandBoxService service;


    @Test
    public void test() {
        R<StringBuilder> post = service.request("POST", "{\n" +
                "    \"cmd\": [{\n" +
                "        \"args\": [\"/usr/bin/g++\", \"a.cc\", \"-o\", \"a\"],\n" +
                "        \"env\": [\"PATH=/usr/bin:/bin\"],\n" +
                "        \"files\": [{\n" +
                "            \"content\": \"\"\n" +
                "        }, {\n" +
                "            \"name\": \"stdout\",\n" +
                "            \"max\": 10240\n" +
                "        }, {\n" +
                "            \"name\": \"stderr\",\n" +
                "            \"max\": 10240\n" +
                "        }],\n" +
                "        \"cpuLimit\": 10000000000,\n" +
                "        \"memoryLimit\": 104857600,\n" +
                "        \"procLimit\": 50,\n" +
                "        \"copyIn\": {\n" +
                "            \"a.cc\": {\n" +
                "                \"content\": \"#include <iostream>\\nusing namespace std;\\nint main() {\\nint a=1, b=2;\\ncout << a + b << endl;\\n}\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"copyOut\": [\"stdout\", \"stderr\"],\n" +
                "        \"copyOutCached\": [\"a\"]\n" +
                "    }]\n" +
                "}");
        System.out.println(post);
    }

}
