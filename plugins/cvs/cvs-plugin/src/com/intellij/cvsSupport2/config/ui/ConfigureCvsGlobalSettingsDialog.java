/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.cvsSupport2.config.ui;

import com.intellij.cvsSupport2.config.CvsApplicationLevelConfiguration;
import com.intellij.openapi.help.HelpManager;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.InputException;

import javax.swing.*;

/**
 * author: lesya
 */

public class ConfigureCvsGlobalSettingsDialog extends DialogWrapper {
  private final GlobalCvsSettingsPanel myGlobalCvsSettingsPanel = new GlobalCvsSettingsPanel();

  public ConfigureCvsGlobalSettingsDialog() {
    super(true);
    setTitle(com.intellij.CvsBundle.message("dialog.title.global.cvs.settings"));
    myGlobalCvsSettingsPanel.updateFrom(CvsApplicationLevelConfiguration.getInstance());
    init();
  }

  protected JComponent createCenterPanel() {
    return myGlobalCvsSettingsPanel.getPanel();
  }

  protected void doOKAction() {
    try {
      myGlobalCvsSettingsPanel.saveTo(CvsApplicationLevelConfiguration.getInstance());
    }
    catch (InputException ex) {
      ex.show();
      return;
    }
    super.doOKAction();
  }

  protected void doHelpAction() {
    HelpManager.getInstance().invokeHelp("dialogs.globalCvsSettings");
  }

  protected Action[] createActions() {
    return new Action[]{getOKAction(), getCancelAction(), getHelpAction()};
  }

}
