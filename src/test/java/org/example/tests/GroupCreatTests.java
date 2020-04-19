package org.example.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.GroupData;
import org.example.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreatTests extends  TestBase {

   @DataProvider
   public Iterator<Object[]> validGroupsFromJson() throws IOException {
      try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
         String json = "";//В эту переменную читаю содержиоме файла
         String line = reader.readLine();
         while (line != null) {
            json += line;
            line = reader.readLine();
         }
         Gson gson = new Gson();
         List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
         }.getType()); //List<GroupData>.class
         return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
      }
   }

   @Test(priority = 0, dataProvider = "validGroupsFromJson")
   public void testGroupCreation(GroupData group) {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      assertThat(app.group().count(), equalTo(before.size() + 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
   }
}
//priority = 0, dataProvider = "validGroupsFromJson"