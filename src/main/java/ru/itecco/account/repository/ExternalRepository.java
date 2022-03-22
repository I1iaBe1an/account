
package ru.itecco.account.repository;

import org.springframework.stereotype.Component;

/**
 * ExternalRepository.
 *
 * @author Belan Ilya
 */
@Component
public class ExternalRepository {

    public String getInfo() {
        return "EXTERNAL_INFO";
    }

}