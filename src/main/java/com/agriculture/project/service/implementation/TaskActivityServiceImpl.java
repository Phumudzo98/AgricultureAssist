package com.agriculture.project.service.implementation;

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
        return List.of();
    }

    @Override
    public Optional<TaskActivity> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public TaskActivity updateTask(Long id, TaskActivity updated) {
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
