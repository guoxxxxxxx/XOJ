/**
 * @Time: 2024/3/30 16:11
 * @Author: guoxun
 * @File: SendAuthCodeController
 * @Description:
 */

package com.pipi.xoj.authority.controller;

import com.pipi.xoj.authority.dto.AuthCodeDTO;
import com.pipi.xoj.authority.utils.EmailMessage;
import com.pipi.xoj.authority.utils.MailUtils;
import com.pipi.xoj.authority.utils.RandomCodeUtils;
import com.pipi.xoj.common.core.response.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class SendAuthCodeController {

    @PostMapping("/sendCode")
    public R<AuthCodeDTO> sendCode(@RequestBody AuthCodeDTO authCodeDTO){
        String code = RandomCodeUtils.getRandomCode();
        MailUtils.sendMessage(code, authCodeDTO.getTargetEmail(), EmailMessage.EMAIL_BASE_MSG.getSubject(),
                EmailMessage.EMAIL_BASE_MSG.getText(), EmailMessage.EMAIL_BASE_MSG.getTime());
        authCodeDTO.setCode(code);
        return R.successResponse(authCodeDTO);
    }
}
