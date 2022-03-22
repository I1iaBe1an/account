
package ru.itecco.account.service;

import org.springframework.stereotype.Component;
import ru.itecco.account.model.ExternalInfo;

/**
 * ProcessImpl.
 *
 * @author Belan Ilya
 */
@Component
public class ProcessImpl implements Process {
    @Override
    public boolean run(ExternalInfo externalInfo) {
        return false;
    }
}