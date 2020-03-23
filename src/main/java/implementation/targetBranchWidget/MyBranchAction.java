/*
 * Copyright 2000-2016 JetBrains s.r.o.
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
package implementation.targetBranchWidget;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.ui.LayeredIcon;
import com.intellij.util.ui.EmptyIcon;
import git4idea.repo.GitRepository;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public abstract class MyBranchAction extends AnAction {

  private final GitRepository repo;

  private boolean myIsFavorite;
  private LayeredIcon myIcon;
  private LayeredIcon myHoveredIcon;

  protected String myBranchName;

  public MyBranchAction(GitRepository repo, String label) {

    super(label);

    setIcons(AllIcons.Nodes.Favorite, EmptyIcon.ICON_16, AllIcons.Nodes.Favorite, AllIcons.Nodes.NotFavoriteOnHover);

    this.repo = repo;
    this.myBranchName = label;

  }

  protected void setIcons(@NotNull Icon favorite,
                          @NotNull Icon notFavorite,
                          @NotNull Icon favoriteOnHover,
                          @NotNull Icon notFavoriteOnHover) {
    myIcon = new LayeredIcon(favorite, notFavorite);
    myHoveredIcon = new LayeredIcon(favoriteOnHover, notFavoriteOnHover);
    getTemplatePresentation().setIcon(myIcon);
    getTemplatePresentation().setSelectedIcon(myHoveredIcon);
    updateIcons();
  }

  @NotNull
  public String getBranchName() {
    return myBranchName;
  }

  private void updateIcons() {
    myIcon.setLayerEnabled(0, myIsFavorite);
    myHoveredIcon.setLayerEnabled(0, myIsFavorite);

    myIcon.setLayerEnabled(1, !myIsFavorite);
    myHoveredIcon.setLayerEnabled(1, !myIsFavorite);
  }

  public boolean isFavorite() {
    return myIsFavorite;
  }

  public void setFavorite(boolean favorite) {
    myIsFavorite = favorite;
    updateIcons();
  }

  public void toggle() {
    setFavorite(!myIsFavorite);
  }

  public String getRepoName() {
    return this.repo.toString();
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent e) {
  }

}
