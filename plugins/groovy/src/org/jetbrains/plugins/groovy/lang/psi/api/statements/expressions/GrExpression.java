/*
 * Copyright 2000-2007 JetBrains s.r.o.
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

package org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions;

import org.jetbrains.plugins.groovy.lang.psi.api.auxiliary.GrCondition;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.GrStatement;
import com.intellij.psi.PsiType;
import com.intellij.util.IncorrectOperationException;

/**
 * @author ilyas
 */
public interface GrExpression extends GrStatement, GrCondition {
  GrExpression[] EMPTY_ARRAY = new GrExpression[0];
  PsiType getType();

  GrExpression replaceWithExpresssion(GrExpression expression) throws IncorrectOperationException;
}
