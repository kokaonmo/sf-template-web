package com.exem.sf.common;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;
import java.util.Optional;

/**
 * Created by CHOI SUNG HOON on 2017. 6. 23..
 */
public class MessageSourceAccessor {
    private MessageSource messageSource;

    public MessageSourceAccessor(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    public Optional<String> getMessage(String code, Locale locale) {
        return Optional.ofNullable(messageSource.getMessage(code, null, null, locale));
    }

    public Optional<String> getMessage(String code, Object[] args, Locale locale) {
        System.out.println(messageSource.getMessage(code, args, null, locale));
        return Optional.ofNullable(messageSource.getMessage(code, args, null, locale));
    }

    public Optional<String> getMessage(MessageSourceResolvable resolvable, Locale locale) {
        try {
            return Optional.of(messageSource.getMessage(resolvable, locale));
        } catch(NoSuchMessageException e) {
            return Optional.empty();
        }
    }
}
