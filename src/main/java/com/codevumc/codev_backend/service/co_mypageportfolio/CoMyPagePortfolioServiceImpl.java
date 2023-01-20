package com.codevumc.codev_backend.service.co_mypageportfolio;

import com.codevumc.codev_backend.domain.CoPortfolio;
import com.codevumc.codev_backend.errorhandler.CoDevResponse;
import com.codevumc.codev_backend.mapper.CoMyPagePortfolioMapper;
import com.codevumc.codev_backend.service.ResponseService;
import lombok.AllArgsConstructor;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CoMyPagePortfolioServiceImpl extends ResponseService implements CoMyPagePortfolioService {
    private final CoMyPagePortfolioMapper coMyPagePortfolioMapper;

    @Override
    public void insertCoPortfolio(CoPortfolio coPortfolio, JSONArray co_languages, JSONArray co_links) {
        this.coMyPagePortfolioMapper.insertCoPortfolio(coPortfolio);
        for (Object co_language : co_languages) {
            long co_languageId = (long) co_language;
            this.coMyPagePortfolioMapper.insertCoLanguageOfPortfolio(coPortfolio.getCo_portfolioId(), co_languageId);
        }
        for (Object co_plink : co_links) {
            String co_link = (String) co_plink;
            this.coMyPagePortfolioMapper.insertCoLinkOfPortfolio(coPortfolio.getCo_portfolioId(), co_link);
        }
    }

    @Override
    public CoDevResponse getCoPortfolio(long co_portfolioId,String co_email) {
        Map<String, Object> coPortfolioDto = new HashMap<>();
        coPortfolioDto.put("co_email",co_email);
        coPortfolioDto.put("co_portfolioId",co_portfolioId);
        try {
            Optional<CoPortfolio> coPortfolio = coMyPagePortfolioMapper.getCoPortfolio(coPortfolioDto);
            if (coPortfolio.isPresent()){
                return setResponse(200,"Complete", coPortfolio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CoDevResponse updateCoPortfolio(CoPortfolio coPortfolio, JSONArray co_languages, JSONArray co_links) {
        Map<String,Object> coPortfolioDto = new HashMap<>();
        coPortfolioDto.put("co_email",coPortfolio.getCo_email());
        coPortfolioDto.put("co_portfolioId",coPortfolio.getCo_portfolioId());
        try{
            Optional<CoPortfolio> coPortfolio1 = coMyPagePortfolioMapper.getCoPortfolio(coPortfolioDto);
            if(coPortfolio1.isPresent()){
                if(coMyPagePortfolioMapper.updateCoPortfolio(coPortfolio)){
                    for (Object co_language : co_languages) {
                        long co_languageId = (long) co_language;
                        coMyPagePortfolioMapper.insertCoLanguageOfPortfolio(coPortfolio.getCo_portfolioId(), co_languageId);
                    }
                    for (Object co_plink : co_links) {
                        String co_link = (String) co_plink;
                        coMyPagePortfolioMapper.insertCoLinkOfPortfolio(coPortfolio.getCo_portfolioId(), co_link);
                    }
                    return setResponse(200,"Complete","수정 완료되었습니다.");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CoDevResponse deletePortfolio(String co_email, long co_portfolioId) {
        Map<String, Object> coPortfolioDto = new HashMap<>();
        coPortfolioDto.put("co_email", co_email);
        coPortfolioDto.put("co_portfolioId", co_portfolioId);
        try {
            Optional<CoPortfolio> coPortfolio = coMyPagePortfolioMapper.getCoPortfolio(coPortfolioDto);
            if (coPortfolio.isPresent()) {
                this.coMyPagePortfolioMapper.deletePortfolio(coPortfolioDto);
                return setResponse(200, "Complete", "삭제되었습니다.");
            } else {
                return setResponse(403, "Forbidden", "수정 권한이 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
