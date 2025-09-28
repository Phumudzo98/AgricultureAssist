package com.agriculture.project.service.implementation;

import com.agriculture.project.dto.TaskActivityDto;
import com.agriculture.project.mapper.TaskActivityMapper;
import com.agriculture.project.model.LandDetails;
import com.agriculture.project.model.TaskActivity;
import com.agriculture.project.repository.LandDetailsRepository;
import com.agriculture.project.repository.TaskActivityRepository;
import com.agriculture.project.service.initialization.TaskActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TaskActivityServiceImpl implements TaskActivityService {

    @Autowired
    private TaskActivityRepository taskActivityRepository;
    @Autowired
    private LandDetailsRepository landDetailsRepository;
    private final TaskActivityMapper taskActivityMapper;

    @Override
    public TaskActivity createTask(TaskActivity taskActivity, Long landId) {

        Optional<LandDetails> landDetails = landDetailsRepository.findById(landId);

        if (landDetails.isPresent()) {

            LandDetails landDetail = landDetails.get();
            taskActivity.setLandDetails(landDetail);

            return taskActivityRepository.save(taskActivity);
        }
        return null;
    }

    @Override
    public List<TaskActivity> getByLand(Long landId) {

        return taskActivityRepository.findByLandDetailsId(landId);
    }

    @Override
    public List<TaskActivity> getByDate(LocalDate date) {
        return taskActivityRepository.findByTaskDate(date);
        

    }

    @Override
    public TaskActivity getById(Long id) {
        Optional<TaskActivity> taskActivity = taskActivityRepository.findById(id);

        if (taskActivity.isPresent()) {
            return taskActivity.get();
        }

        return null;
    }

    @Override
    public TaskActivity updateTask(Long id, TaskActivityDto updated) {
        TaskActivity taskActivity = taskActivityMapper.toEntity(updated);

        Optional<LandDetails> landDetails = landDetailsRepository.findById(id);

        if (landDetails.isPresent()) {
            LandDetails landDetail = landDetails.get();

            taskActivity.setLandDetails(landDetail);
            return taskActivityRepository.save(taskActivity);
        }

        return null;
    }

    @Override
    public Boolean delete(Long id) {

        Optional<TaskActivity> taskActivity = taskActivityRepository.findById(id);

        if (taskActivity.isPresent()) {
            taskActivityRepository.delete(taskActivity.get());
            return true;
        }
        return false;
    }
}
