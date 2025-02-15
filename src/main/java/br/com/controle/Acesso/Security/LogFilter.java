package br.com.controle.Acesso.Security;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class LogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws IOException, javax.servlet.ServletException {
        System.out.println("Requisição recebida: " + request.getRequestURI());
        System.out.println("Método HTTP: " + request.getMethod());
        
        filterChain.doFilter(request, response);  // Continue o fluxo
    }
}
