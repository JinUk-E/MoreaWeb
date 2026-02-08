package com.moraegames.adminweb.util

class Constants {
    companion object {
        // 인증용 상수 모음
        const val DeepLinksJson =  "[{\n" +
                "  \"relation\": [\"delegate_permission/common.handle_all_urls\"],\n" +
                "  \"target\": {\n" +
                "    \"namespace\": \"android_app\",\n" +
                "    \"package_name\": \"com.moraegames.moraesdk2\",\n" +
                "    \"sha256_cert_fingerprints\":\n" +
                "    [\"60:AD:EB:85:A4:8F:F4:E6:77:99:DC:F7:BA:C7:9E:DF:63:34:83:B9:A2:20:68:26:DF:08:C8:AC:06:E6:BF:00\"]\n" +
                "  }\n" +
                "}]"

        const val AASA = "{\n" +
                "  \"applinks\": {\n" +
                "    \"apps\": [],\n" +
                "    \"details\": [\n" +
                "      {\n" +
                "        \"appID\": \"Temp.com\",\n" +
                "        \"paths\": [\"*\"]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}"

        const val app_ads = "google.com, pub-4792632080704346, DIRECT, f08c47fec0942fa0"

        
        // 페이지 경로 모음
        const val LoginSuccessPath = "/moraeAdmin/main"
    }
}