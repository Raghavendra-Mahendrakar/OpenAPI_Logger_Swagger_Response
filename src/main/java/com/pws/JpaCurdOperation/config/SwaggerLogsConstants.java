package com.pws.JpaCurdOperation.config;

public class SwaggerLogsConstants {
        public static final String STUDENT_SAVED_200_SUCCESSFULL="can't parse JSON.  Raw result:\n" +
                "\n" +
                "Student Details saved";

        public static final String STUDENT_SAVED_400_FAILURE="{\n" +
                "  \"timestamp\": \"2023-02-25T06:51:46.813+00:00\",\n" +
                "  \"status\": 400,\n" +
                "  \"error\": \"Bad Request\",\n" +
                "  \"path\": \"/student/saveStudent\"\n" +
                "}";
}
