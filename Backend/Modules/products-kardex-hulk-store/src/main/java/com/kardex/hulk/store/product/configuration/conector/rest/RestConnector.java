package com.kardex.hulk.store.product.configuration.conector.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.support.RestGatewaySupport;

import javax.net.ssl.SSLContext;
import java.io.Serializable;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class RestConnector extends RestGatewaySupport implements Serializable {

    private static HttpHeaders createHeaders(Map<String, String> headers) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpHeaders.set(header.getKey(), header.getValue());
            }
        }
        return httpHeaders;
    }

    public final <T> T post(String uri, Object body, Class<T> responseClass, MediaType mediaType, Map<String, String> headers) {
        return this.exchange(HttpMethod.POST, uri, responseClass, mediaType, headers, body, null, null);
    }

    public final <T> T post(String uri, Object body, Class<T> responseClass, MediaType mediaType, Map<String, String> headers, String crtUri, String crtPassword) {
        return this.exchange(HttpMethod.POST, uri, responseClass, mediaType, headers, body, crtUri, crtPassword);
    }

    public final <T> T get(String uri, Class<T> responseClass, MediaType mediaType, Map<String, String> headers) {
        return this.exchange(HttpMethod.GET, uri, responseClass, mediaType, headers, null, null, null);
    }

    public final <T> T get(String uri, Class<T> responseClass, MediaType mediaType, Map<String, String> headers, String crtUri, String crtPassword) {
        return this.exchange(HttpMethod.GET, uri, responseClass, mediaType, headers, null, crtUri, crtPassword);
    }

    public final <T> T put(String uri, Object body, Class<T> responseClass, MediaType mediaType, Map<String, String> headers) {
        return this.exchange(HttpMethod.PUT, uri, responseClass, mediaType, headers, body, null, null);
    }

    public final <T> T put(String uri, Object body, Class<T> responseClass, MediaType mediaType, Map<String, String> headers, String crtUri, String crtPassword) {
        return this.exchange(HttpMethod.PUT, uri, responseClass, mediaType, headers, body, crtUri, crtPassword);
    }

    private <T> T exchange(HttpMethod method, String url, Class<T> responseClass, MediaType mediaType, Map<String, String> headers, Object body, String crtUri, String crtPassword) {

        HttpHeaders httpHeaders = createHeaders(headers);
        if (!Objects.isNull(mediaType)) {
            httpHeaders.setAccept(Collections.singletonList(mediaType));
            httpHeaders.setContentType(mediaType);
        }

        HttpEntity<T> httpEntity;
        if(Objects.isNull(body)) {
            httpEntity = new HttpEntity(httpHeaders);
        }else {
            httpEntity = new HttpEntity(body, httpHeaders);
        }

        try {
            var restTemplate = getRestTemplate();

            if(!Objects.isNull(crtUri) && !Objects.isNull(crtPassword)) {
                TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

                SSLContext sslContext = SSLContextBuilder
                        .create()
                        .loadKeyMaterial(ResourceUtils.getFile(crtUri), crtPassword.toCharArray(), crtPassword.toCharArray())
                        .loadTrustMaterial(null, acceptingTrustStrategy) //accept all (trust ALL certificates)
                        .build();

                HttpClient client = HttpClients.custom()
                        .setSSLContext(sslContext)
                        .build();

                restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));
            }
            return restTemplate.exchange(url, method, httpEntity, responseClass).getBody();
        } catch (HttpClientErrorException ex) {
            try {
                String exceptionBody = ex.getResponseBodyAsString();
                if (!exceptionBody.isEmpty()) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.readValue(exceptionBody, responseClass);
                }
            } catch (JsonProcessingException jsonMappingException) {
                log.error(String.format("%s:[%s]","Exception RestConnector", jsonMappingException.getMessage()));
            }
        } catch (Exception ex) {
            log.error(String.format("%s:[%s]","Exception RestConnector", ex.getMessage()));
        }
        return null;
    }
}
