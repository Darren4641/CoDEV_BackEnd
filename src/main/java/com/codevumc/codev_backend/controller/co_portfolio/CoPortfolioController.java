package com.codevumc.codev_backend.controller.co_portfolio;

import com.codevumc.codev_backend.controller.JwtController;
import com.codevumc.codev_backend.jwt.JwtTokenProvider;
import com.codevumc.codev_backend.service.co_portfolio.CoPortfolioServiceImpl;
import com.codevumc.codev_backend.service.co_user.JwtService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/p1/co_portfolio")
public class CoPortfolioController extends JwtController {
    private final CoPortfolioServiceImpl coPortfolioService;

    public CoPortfolioController(JwtTokenProvider jwtTokenProvider, JwtService jwtService, CoPortfolioServiceImpl coPortfolioService) {
        super(jwtTokenProvider, jwtService);
        this.coPortfolioService = coPortfolioService;
    }
}