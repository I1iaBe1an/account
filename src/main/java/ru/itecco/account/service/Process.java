
package ru.itecco.account.service;

import ru.itecco.account.model.ExternalInfo;

/**
 * Process.
 *
 * @author Belan Ilya
 */
public interface Process {

    boolean run(ExternalInfo externalInfo);

}