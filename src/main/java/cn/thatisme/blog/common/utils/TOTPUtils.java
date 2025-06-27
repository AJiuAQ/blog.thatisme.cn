package cn.thatisme.blog.common.utils;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.otp.TOTP;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TOTPUtils {

    // 发行者（项目名），可为空，注：不允许包含冒号
    public static final String ISSUER = "thatisme.cn";

    // 生成的key长度( Generate secret key length)
    public static final int SECRET_SIZE = 32;

    // Java实现随机数算法
    public static final String RANDOM_NUMBER_ALGORITHM = "SHA1PRNG";

    // 恢复码数量
    public static final int RECOVERY_CODE_COUNT = 3;
    public static final int RECOVERY_CODE_LENGTH = 8;

    // 最多可偏移的时间, 假设为2，表示计算前面2次、当前时间、后面2次，共5个时间内的验证码
    static int window_size = 1; // max 17

    static long second_per_size = 30L;// 每次时间长度，默认30秒

    private static final int QR_CODE_SIZE = 300; // 二维码尺寸

    /**
     * 生成TOTP密钥（Base32编码）
     */
    public static String generateTotpSecret() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance(RANDOM_NUMBER_ALGORITHM);
        secureRandom.setSeed(getSeed());
        byte[] keyBytes = secureRandom.generateSeed(SECRET_SIZE);
        String ret = Base32.encode(keyBytes);
        return ret.replaceAll("=+$", "");
    }

    private static byte[] getSeed() {
        String str = ISSUER + System.currentTimeMillis() + ISSUER;
        return str.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 生成恢复码（数字字母组合）
     */
    public static List<String> generateRecoveryCodes() {
        List<String> codes = new ArrayList<>(RECOVERY_CODE_COUNT);
        for (int i = 0; i < RECOVERY_CODE_COUNT; i++) {
            String code = RandomUtil.randomString(RECOVERY_CODE_LENGTH).toUpperCase();
            codes.add(code);
        }
        return codes;
    }

    /**
     * 生成TOTP二维码（Base64格式）
     * @param secret TOTP密钥
     * @param account 用户账号
     */
    public static String generateQrCodeBase64(String secret, String account) {
        return generateQrCodeBase64(secret, account, ISSUER);
    }

    /**
     * 生成TOTP二维码（Base64格式）
     * @param secret TOTP密钥
     * @param account 用户账号
     * @param issuer 服务提供方
     */
    public static String generateQrCodeBase64(String secret, String account, String issuer) {
        String otpAuthUrl = String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s",
                issuer, account, secret, issuer);

        QrConfig config = new QrConfig(QR_CODE_SIZE, QR_CODE_SIZE);
        config.setMargin(2);
        return QrCodeUtil.generateAsBase64(otpAuthUrl, config, "png");
    }

    /**
     * 验证TOTP验证码
     * @param secret TOTP密钥
     * @param offsetSize 允许的时间窗口偏移量（单位：步长）
     * @param code 用户输入的验证码
     */
    public static boolean validateTotpCode(String secret, int offsetSize, int code) {
        TOTP totp = new TOTP(Base32.decode(secret));
        return totp.validate(Instant.now(), offsetSize, code);
    }

    /**
     * 快速验证方法（默认允许前后1个时间窗口）
     */
    public static boolean validateTotpCode(String secret, int code) {
        return validateTotpCode(secret, window_size, code);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String secret = generateTotpSecret();
        System.out.println(secret);
        System.out.println(generateRecoveryCodes());
//        System.out.println(generateQrCodeBase64(secret, "thatisme", "thatisme.cn"));
//        "FZ63K3JKIJE2KCLMMKUXGLOMSE======"
        System.out.println(validateTotpCode("FZ63K3JKIJE2KCLMMKUXGLOMSE======", 244167));
    }
}