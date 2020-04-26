package com.demo.mediaserver.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/media")
public class MediaController {

  /**
   * @formatter:off
   * This controller allows you to download a video. It loads the entire video in memory in byte[].
   * This is not good for performance. This controller results in OutOfMemory when you send 2-3 requests at same time.
   * 
   * You can download the file using http://localhost:8080/media/download/video
   * Try sending multiple requests and see server failing due to OutOfMemory.
   * 
   * @formatter:on
   */
  @RequestMapping(method = RequestMethod.GET, path = "/download/video")
  public ResponseEntity<byte[]> downloadVideo() throws IOException {
    Resource fileResource = new ClassPathResource("LargeVideo.mp4");
    byte[] videoBytes = FileCopyUtils.copyToByteArray(fileResource.getInputStream());

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaTypeFactory.getMediaType(fileResource).orElse(MediaType.APPLICATION_OCTET_STREAM));
    return new ResponseEntity<byte[]>(videoBytes, headers, HttpStatus.OK);
  }

  /**
   * @formatter:off
   * This controller allows you to download a video. It does not load the entire video in memory.
   * This is good for performance.
   * 
   * You can download the file using http://localhost:8080/media/stream/video
   * Try sending multiple requests and see server still able to serve the requests.
   * 
   * @formatter:on
   */
  @RequestMapping(method = RequestMethod.GET, path = "/stream/video")
  public ResponseEntity<InputStreamResource> streamVideo() throws IOException {
    Resource fileResource = new ClassPathResource("LargeVideo.mp4");

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaTypeFactory.getMediaType(fileResource).orElse(MediaType.APPLICATION_OCTET_STREAM));

    InputStreamResource resource = new InputStreamResource(fileResource.getInputStream());
    return new ResponseEntity<InputStreamResource>(resource, headers, HttpStatus.OK);
  }

  /**
   * @formatter:off
   * This controller allows you to download a file.
   * Through cache-control header, it directs browser to cache the file in local storage.
   * 
   * You can download the file using http://localhost:8080/media/cache/file
   * @formatter:on
   */
  @RequestMapping(method = RequestMethod.GET, path = "/cache/file")
  public ResponseEntity<InputStreamResource> getCacheFile() throws IOException {
    Resource fileResource = new ClassPathResource("CachedFile.txt");

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.TEXT_PLAIN);

    CacheControl cacheControl = CacheControl.maxAge(60, TimeUnit.SECONDS).noTransform();
    headers.setCacheControl(cacheControl);

    InputStreamResource resource = new InputStreamResource(fileResource.getInputStream());
    return new ResponseEntity<InputStreamResource>(resource, headers, HttpStatus.OK);
  }

  /**
   * @formatter:off
   * This controller allows you to download a file.
   * The cache-control settings for this URL are set in WebConfig.
   * 
   * You can download the file using http://localhost:8080/media/webcache/xml
   * @formatter:on
   */
  @RequestMapping(method = RequestMethod.GET, path = "/webcache/xml")
  public ResponseEntity<InputStreamResource> getCacheXML() throws IOException {
    Resource fileResource = new ClassPathResource("CachedXML.xml");

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_XML);

    InputStreamResource resource = new InputStreamResource(fileResource.getInputStream());
    return new ResponseEntity<InputStreamResource>(resource, headers, HttpStatus.OK);
  }

  /**
   * @formatter:off
   * This controller allows you to download a file.
   * The cache-control settings for this URL are set in WebConfig.
   * 
   * You can download the file using http://localhost:8080/media/webcache/json
   * @formatter:on
   */
  @RequestMapping(method = RequestMethod.GET, path = "/webcache/json")
  public ResponseEntity<InputStreamResource> getValidatedCacheJSON(WebRequest webRequest) throws IOException {
    File file = new File("D://CachedJSON.json");
    long lastModifiedTimestamp = file.lastModified();

    if (webRequest.checkNotModified(lastModifiedTimestamp)) {
      return ResponseEntity.status(304).build();
    }
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
    return new ResponseEntity<InputStreamResource>(resource, headers, HttpStatus.OK);
  }

}
