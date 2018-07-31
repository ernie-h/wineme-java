package com.example.myapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.repositories.TopicRepository;
import com.example.myapp.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*")
public class WidgetService {
	@Autowired
	WidgetRepository widgetRepository;
	@Autowired
	TopicRepository topicRepository;
	
	@GetMapping("/api/topic/{topicId}/widget")
	public List<Widget> findAllWidgetsForTopic(@PathVariable("topicId") int topicId) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if(data.isPresent()) {
			Topic topic = data.get();
			return topic.getWidgets();
		}
		return null;
	}
	
	@GetMapping("/api/widget")
	public List<Widget> findAllWidgets() {
		return (List<Widget>) widgetRepository.findAll();
	}
	@PostMapping("/api/topic/{topicId}/widget")
	public Widget createWidget(
      @PathVariable("topicId") int topicId,
			@RequestBody Widget newWidget) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if(data.isPresent()) {
			Topic topic = data.get();
			newWidget.setTopic(topic);
			return widgetRepository.save(newWidget);
		}
		return null;
	}
	
	@DeleteMapping("/api/widget/{widgetId}")
	public void deleteWidget(@PathVariable("widgetId") int id) {
		widgetRepository.deleteById(id);
	}
	
	@GetMapping("/api/widget/{widgetId}")
	public Widget findWidgetById(@PathVariable("widgetId") int widgetId) {
		Optional<Widget> data = widgetRepository.findById(widgetId);
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}
	
	@PutMapping("/api/widget/{widgetId}")
	public Widget updateWidget(@PathVariable("widgetId") int widgetId, @RequestBody Widget newWidget) {
		Optional<Widget> data = widgetRepository.findById(widgetId);
		if(data.isPresent()) {
			Widget widget = data.get();
			widget.setName(newWidget.getName());
			widget.setClassName(newWidget.getClassName());
			widget.setLocation(newWidget.getLocation());
			widget.setText(newWidget.getText());
			widget.setStyle(newWidget.getStyle());
			widget.setWidth(newWidget.getWidth());
			widget.setHeight(newWidget.getHeight());
			widget.setSrc(newWidget.getSrc());
			widget.setListItems(newWidget.getListItems());
			widget.setOrdered(newWidget.getOrdered());
			widget.setSize(newWidget.getSize());
			widget.setHref(newWidget.getHref());
			widgetRepository.save(widget);
			return widget;
		}
		return null;
	}

	@PutMapping("/api/widget/save")
	public List<Widget> saveAllWidgets(@RequestBody List<Widget> widgets) {
			for(Widget widget: widgets) {
				this.updateWidget(widget.getId(), widget);
			}
		return widgets;
	}
}