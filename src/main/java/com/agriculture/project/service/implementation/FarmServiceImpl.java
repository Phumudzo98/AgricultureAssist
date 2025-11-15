package com.agriculture.project.service.implementation;

import com.agriculture.project.dto.FarmDto;
import com.agriculture.project.dto.FarmOverviewDto;
import com.agriculture.project.mapper.FarmMapper;
import com.agriculture.project.model.Farm;
import com.agriculture.project.model.LandDetails;
import com.agriculture.project.model.User;
import com.agriculture.project.repository.FarmRepository;
import com.agriculture.project.repository.LandDetailsRepository;
import com.agriculture.project.repository.UserRepository;
import com.agriculture.project.service.initialization.FarmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FarmServiceImpl implements FarmService {


    private final ObjectMapper objectMapper;
    private final FarmRepository farmRepository;
    private final FarmMapper farmMapper;
    private final UserRepository userRepository;
    private final LandDetailsRepository landDetailsRepository;

    public FarmServiceImpl(ObjectMapper objectMapper, FarmRepository farmRepository, FarmMapper farmMapper, UserRepository userRepository, LandDetailsRepository landDetailsRepository) {
        this.objectMapper = objectMapper;
        this.farmRepository = farmRepository;
        this.farmMapper = farmMapper;
        this.userRepository = userRepository;
        this.landDetailsRepository = landDetailsRepository;
    }

    @Override
    public List<Farm> getFarms() {

        Optional<User> optionalUser = userRepository.findByEmail(getCurrentUserEmail());

        if(optionalUser.isPresent()) {
            User user = optionalUser.get();

           return farmRepository.findByUser(user);
        }

        return Collections.emptyList();
    }

    @Override
    public Farm getFarmById(Long id) {

        Optional<Farm> optionalFarm = farmRepository.findById(id);

        if(optionalFarm.isPresent()) {
            return optionalFarm.get();
        }
        return null;
    }

    @Override
    public Farm createFarm(FarmDto farm) {

        Farm convertedFarm = farmMapper.fromDto(farm);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        convertedFarm.setUser(user);

        if (convertedFarm.getLandDetails() != null) {
            convertedFarm.getLandDetails().forEach(land -> land.setFarm(convertedFarm));
        }

        return farmRepository.save(convertedFarm);
    }

    @Override
    public Farm updateFarm(FarmDto farm) {

        if(farm!=null)
        {
            return farmRepository.save(farmMapper.fromDto(farm));
        }
        return null;
    }

    @Override
    public boolean deleteFarm(Long id) {

        Farm farm = getFarmById(id);

        if(farm!=null)
        {
            farmRepository.delete(farm);
            return true;
        }
        return false;
    }

    @Override
    public List<Farm> searchFarm(String search) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        List<Farm> farms = farmRepository.findByUserAndFarmNameContainingIgnoreCase(user,search);


        return farms;
    }

    @Override
    public FarmOverviewDto getFarmOverview(Long farmId) {

        Optional<Farm> optionalFarm = farmRepository.findById(farmId);



        if(optionalFarm.isPresent()) {

            Farm farm = optionalFarm.get();
            List<LandDetails> landDetails = landDetailsRepository.findByFarm(farm);
            FarmOverviewDto farmOverviewDto = new FarmOverviewDto();

            farmOverviewDto.setFarmType(farm.getFarm_type());
            farmOverviewDto.setFarmName(farm.getFarmName());
            farmOverviewDto.setLocation(farm.getFarm_location());
            farmOverviewDto.setNumberOfSections(String.valueOf(landDetails != null ? landDetails.size() : 0));
            farmOverviewDto.setTotalSize(String.valueOf(farm.getSize()));

            return farmOverviewDto;

        }
        return null;
    }

    private String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("No authenticated user found");
        }
        return authentication.getName();
    }
}