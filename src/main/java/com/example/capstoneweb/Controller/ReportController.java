package com.example.capstoneweb.Controller;


import com.example.capstoneweb.service.FlaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReportController {

    @Autowired
    private FlaskService flaskService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/generate-report")
    public String generateReport(@RequestParam("userMsg") String userMsg, Model model) {
        String response = flaskService.generateReport(userMsg);
        model.addAttribute("message", response);
        return "result";
    }

    @GetMapping("/download-report")
    @ResponseBody
    public byte[] downloadReport() {
        return flaskService.downloadReport();
    }
}
