package com.agriculture.project.service.implementation;

import com.agriculture.project.dto.FarmDto;
import com.agriculture.project.dto.FarmOverviewDto;
import com.agriculture.project.mapper.FarmMapper;
import com.agriculture.project.model.Farm;
import com.agriculture.project.model.User;
import com.agriculture.project.repository.FarmRepository;
import com.agriculture.project.repository.UserRepository;
import com.agriculture.project.service.initialization.FarmService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final FarmMapper farmMapper;
    private final UserRepository userRepository;

    public FarmServiceImpl(FarmRepository farmRepository, FarmMapper farmMapper, UserRepository userRepository) {
        this.farmRepository = farmRepository;
        this.farmMapper = farmMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<Farm> getFarms() {
        return farmRepository.findAll();
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
        return List.of();
    }

    @Override
    public FarmOverviewDto getFarmOverview(Long farmId) {

        Optional<Farm> optionalFarm = farmRepository.findById(farmId);

        if(optionalFarm.isPresent()) {

            Farm farm = optionalFarm.get();
            FarmOverviewDto farmOverviewDto = new FarmOverviewDto();

            farmOverviewDto.setFarmType(farm.getFarm_type());
            farmOverviewDto.setFarmName(farm.getFarm_name());
            farmOverviewDto.setLocation(String.format("%.2f", farm.getFarm_location()));
            farmOverviewDto.setDominantSoilType(farmOverviewDto.getDominantSoilType());
            farmOverviewDto.setNumberOfSections(farmOverviewDto.getNumberOfSections());
            farmOverviewDto.setTotalSize(farmOverviewDto.getTotalSize());

            return farmOverviewDto;

        }
        return null;
    }
}