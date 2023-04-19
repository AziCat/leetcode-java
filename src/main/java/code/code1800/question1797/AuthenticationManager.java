package code.code1800.question1797;

import java.util.HashMap;
import java.util.Map;

/**
 * AuthenticationManager(int timeToLive) 构造 AuthenticationManager 并设置 timeToLive 参数。
 * generate(string tokenId, int currentTime) 给定 tokenId ，在当前时间 currentTime 生成一个新的验证码。
 * renew(string tokenId, int currentTime) 将给定 tokenId 且 未过期 的验证码在 currentTime 时刻更新。如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
 * countUnexpiredTokens(int currentTime) 请返回在给定 currentTime 时刻，未过期 的验证码数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-authentication-manager
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/2/9
 */
public class AuthenticationManager {
    private final int timeToLive;
    private final Map<String, Integer> tokenMap;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenMap = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokenMap.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        Integer expire = tokenMap.get(tokenId);
        if (null != expire) {
            if (expire > currentTime) {
                generate(tokenId, currentTime);
            } else {
                tokenMap.remove(tokenId);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String tokenId : tokenMap.keySet()) {
            Integer expire = tokenMap.get(tokenId);
            if (null != expire) {
                if (expire > currentTime) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AuthenticationManager manager = new AuthenticationManager(3);
        System.out.println(manager.countUnexpiredTokens(1));
        manager.generate("mqjfa", 2);
        manager.generate("xg", 5);
        manager.generate("dvm", 8);
        manager.renew("euxli", 9);
        System.out.println(manager.countUnexpiredTokens(11));
        manager.renew("oin", 13);
        System.out.println(manager.countUnexpiredTokens(18));
    }
}
