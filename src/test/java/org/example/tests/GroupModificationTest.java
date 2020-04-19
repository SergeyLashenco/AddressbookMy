package org.example.tests;

import org.example.model.GroupData;
import org.example.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {


   @Test() //priority = 2
   public void testGroupModification() {
/*
  Groups before = app.groups();
      GroupData modificationGroup = before.iterator().next();
      GroupData group = new GroupData()
              .withId(modificationGroup.getId())
              .withName("test1")
              .withHeader("test2")
              .withFooter("test3");
      app.goTo().groupPage();
      app.group().modify(group);
      assertThat(app.group().count(), equalTo(before.size()));
      Groups after = app.db().groups();
      assertThat(after, equalTo(before.without(modificationGroup).withAdded(group)));
 */

   }
}
