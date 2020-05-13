package com.cts.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.controller.StoryController;
import com.cts.model.Story;
import com.cts.repository.StoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

	@MockBean
	StoryRepository storyRepository;
	
	@Autowired
	StoryController storyController;
	
	@Test
	public void getAllStoryTest() {
		when(storyRepository.findAll()).thenReturn(Stream.of(new Story((long) 100,"fetch","fetching",(long) 200,"yes"),new Story((long) 101,"Deleting","Deleting",(long) 201,"No")).collect(Collectors.toList()));
		assertEquals(2,storyController.getAllStory().size());
    }
	
	@Test
	public void saveStoryTest() throws Exception {
		Story story=new Story((long) 102,"Update","Updating",(long) 202,"yes");
		when(storyRepository.save(story)).thenReturn(story);
	}
}
