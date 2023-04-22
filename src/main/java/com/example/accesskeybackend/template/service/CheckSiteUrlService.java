package com.example.accesskeybackend.template.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.*;
import java.util.Optional;

@Service
public class CheckSiteUrlService {
    public String check(String siteUrl) {
        try {
            InetAddress[] inet = InetAddress.getAllByName(URI.create(siteUrl).getHost());

            return this.getIPv6Addresses(inet).map(ip -> {
                try {
                    return ip.isReachable(5000);
                } catch (IOException e) {
                    return false;
                }
            }).orElse(Boolean.FALSE).toString();
        } catch (UnknownHostException e) {
            return Boolean.FALSE.toString();
        }
    }

    private Optional<Inet6Address> getIPv6Addresses(InetAddress[] addresses)
    {
        for (InetAddress addr : addresses)
        {
            if (addr instanceof Inet6Address)
            {
                return Optional.of((Inet6Address) addr);
            }
        }
        return Optional.empty();
    }
}
