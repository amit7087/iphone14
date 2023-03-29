package com.iphone14.security.Impl;

import com.iphone14.entity.ClientReg;
import com.iphone14.payload.ClientRegDto;
import com.iphone14.repository.ClientRegRepository;
import com.iphone14.security.ClientRegService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientRegServiceImpl implements ClientRegService {

    private ClientRegRepository clientRegRepository;

    private PasswordEncoder passwordEncoder;

    public ClientRegServiceImpl(ClientRegRepository clientRegRepository, PasswordEncoder passwordEncoder) {
        this.clientRegRepository = clientRegRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ClientRegDto createClientReg(ClientRegDto clientRegDto) {
        ClientReg clientReg = mapToEntity(clientRegDto);
        clientRegRepository.save(clientReg);
        return null;
    }

    ClientReg mapToEntity(ClientRegDto clientRegDto) {
        ClientReg clientReg = new ClientReg();
        clientReg.setClientAddress(clientRegDto.getClientAddress());
        clientReg.setClientName(clientRegDto.getClientName());
        clientReg.setEmail(clientRegDto.getEmail());
        clientReg.setGender(clientRegDto.getGender());
        clientReg.setUsername(clientRegDto.getUsername());
        clientReg.setPassword(passwordEncoder.encode(clientRegDto.getPassword()));
        return clientReg;
    }
}
