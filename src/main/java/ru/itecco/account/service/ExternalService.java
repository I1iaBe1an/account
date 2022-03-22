
package ru.itecco.account.service;

import ru.itecco.account.model.ExternalInfo;

/**
 * ExternalService.
 *
 * @author Belan Ilya
 */
public interface ExternalService {

    ExternalInfo getExternalInfo(Integer id);

}