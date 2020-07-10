package org.huifer.zkview.controller;

import org.huifer.zkview.model.ResultVO;
import org.huifer.zkview.model.req.CreateNodeReq;
import org.huifer.zkview.model.req.UpdateNodeReq;
import org.huifer.zkview.service.INodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/node")
public class NodeController {

  @Autowired
  private INodeService nodeService;

  @GetMapping("/get/child")
  public ResultVO child(
      @RequestParam(value = "path") String path
  ) throws Exception {
    return new ResultVO("ok", nodeService.childList(path), 200);
  }

  @GetMapping("/get/info")
  public ResultVO info(
      @RequestParam(value = "path") String path
  ) throws Exception {
    return new ResultVO("ok", nodeService.info(path), 200);

  }

  @GetMapping("/tree")
  public ResultVO tree() throws Exception {
    return new ResultVO("ok", nodeService.tree(), 200);
  }

  @PostMapping("/create")
  public ResultVO createNode(
      @RequestBody @Validated CreateNodeReq createNodeReq
  ) {
    return new ResultVO("ok", nodeService.create(createNodeReq), 200);
  }

  @PostMapping("/update")
  public ResultVO updateNode(
      @RequestBody @Validated UpdateNodeReq updateNodeReq
  ) {
    return new ResultVO("ok", nodeService.update(updateNodeReq), 200);
  }

  @GetMapping("/del")
  public ResultVO del(
      @RequestParam(value = "path") String path
  ){
    return new ResultVO("ok", nodeService.del(path), 200);

  }
}
