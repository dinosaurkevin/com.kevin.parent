package com.kevin.web.base;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

public abstract class BaseController {

	protected static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

//	final protected String success(String message, String url, Model model, Object[] args) {
//		return this.success(message, model.addAttribute(CoreConstants.URL, url), args);
//	}
//
//	/**
//	 * 显示成功页面2
//	 * 
//	 * @param message
//	 *            提示信息
//	 * @param url
//	 * @param model
//	 * @return
//	 */
//	final protected String success(String message, String url, Model model) {
//		return this.success(message, model.addAttribute(CoreConstants.URL, url), null);
//	}
//
//	/**
//	 * 显示成功页面3
//	 * 
//	 * @param message
//	 *            提示信息
//	 * @param model
//	 * @return
//	 */
//	final protected String success(String message, Model model) {
//		return this.success(message, model, null);
//	}
//
//	/**
//	 * 显示成功页面4
//	 * 
//	 * @param message
//	 *            提示信息
//	 * @param model
//	 * @param args
//	 * @return
//	 */
//	final protected String success(String message, Model model, Object[] args) {
//		if (StringUtils.isNotBlank(message) && ArrayUtils.isNotEmpty(args)) {
//			message = MessageFormat.format(message, args);
//		}
//		model.addAttribute(CoreConstants.MESSAGE, message);
//		model.addAttribute(CoreConstants.MEDIA_TYPE, CoreConstants.HTML);
//		return CoreConstants.SUCCESS;
//	}
//
//	/**
//	 * 显示成功页面5（提示"操作成功"）
//	 * 
//	 * @param model
//	 * @return
//	 */
//	final protected String success(Model model) {
//		return this.success("操作成功", model, null);
//	}
//
//	/**
//	 * 
//	 * 显示失败页面1
//	 * 
//	 * @param errorArg
//	 *            如果是错误码，则需加前缀"@"，表示需要翻译；如果是完整错误信息，直接传。
//	 * @param url
//	 * @param model
//	 * @param args
//	 * @return
//	 */
//	final protected String error(String errorArg, String url, Model model, Object[] args) {
//		return this.error(errorArg, model.addAttribute(CoreConstants.URL, url), args);
//	}
//
//	/**
//	 * 
//	 * 显示失败页面2
//	 * 
//	 * @param errorArg
//	 *            如果是错误码，则需加前缀"@"，表示需要翻译；如果是完整错误信息，直接传。
//	 * @param url
//	 * @param model
//	 * @return
//	 */
//	final protected String error(String errorArg, String url, Model model) {
//		return this.error(errorArg, model.addAttribute(CoreConstants.URL, url), null);
//	}
//
//	/**
//	 * 显示失败页面3
//	 * 
//	 * @param errorArg
//	 *            如果是错误码，则需加前缀"@"，表示需要翻译；如果是完整错误信息，直接传。
//	 * @param model
//	 * @return
//	 */
//	final protected String error(String errorArg, Model model) {
//		return this.error(errorArg, model, null);
//	}
//
//	/**
//	 * 显示失败页面4
//	 * 
//	 * @param errorArg
//	 *            如果是错误码，则需加前缀"@"，表示需要翻译；如果是完整错误信息，直接传。
//	 * @param model
//	 * @return
//	 */
//	final protected String error(String errorArg, Model model, Object[] args) {
//		model.addAttribute(CoreConstants.MESSAGE, this.getErrorInfo(errorArg, args));
//		model.addAttribute(CoreConstants.MEDIA_TYPE, CoreConstants.HTML);
//		return CoreConstants.ERROR;
//	}
//
//	/**
//	 * 重定向
//	 * 
//	 * @param url
//	 * @return
//	 */
//	final protected String redirect(String url) {
//		return "redirect:" + url;
//	}
//
//	/**
//	 * 跳转
//	 * 
//	 * @param url
//	 * @return
//	 */
//	final protected String forward(String url) {
//		return "forward:" + url;
//	}
//
//	/**
//	 * 获取实际消息
//	 * 
//	 * @param errorArg
//	 *            如果是错误码，则需加前缀"@"，表示需要翻译；如果是完整错误信息，直接传。
//	 * @return
//	 */
//	final protected String getErrorInfo(String errorArg) {
//		return this.getErrorInfo(errorArg, null);
//	}
//
//	/**
//	 * 获取实际消息
//	 * 
//	 * @param errorArg
//	 *            如果是错误码，则需加前缀"@"，表示需要翻译；如果是完整错误信息，直接传。
//	 * @param args
//	 * @return
//	 */
//	final protected String getErrorInfo(String errorArg, Object[] args) {
//		if (StringUtils.isNotBlank(errorArg)) {
//			if (errorArg.startsWith("@")) {
//				errorArg = MetadataService.getErrorInfo(Integer.valueOf(errorArg.substring(1)), args);
//			}
//			return errorArg;
//		}
//		return errorArg;
//	}
//
//	/**
//	 * 放置下拉选项，包括默认选项：key=""，value="请选择"
//	 * 
//	 * @param dictCode
//	 * @return
//	 */
//	protected Map<String, String> putSelectOption(int dictCode, Boolean... hasDefault) {
//		Map<String, String> dictMap = new LinkedHashMap<String, String>();
//		if (hasDefault == null || hasDefault.length < 1 || hasDefault[0].equals(true)) {
//			dictMap.put(select_key, "请选择");
//		}
//		// dictMap.putAll(SpringContext.getDictInfo(dictCode));
//		dictMap.putAll(MetadataService.queryDictSub(dictCode));
//		return dictMap;
//	}
//
//	/**
//	 * 放置下拉选项，包括默认选项：key=""，value="请选择"
//	 * 
//	 * @param dictCode
//	 * @return
//	 */
//	protected Map<String, String> putSelectOption(int dictCode, String exchangeId, Boolean... hasDefault) {
//		Map<String, String> dictMap = new LinkedHashMap<String, String>();
//		if (hasDefault == null || hasDefault.length < 1 || hasDefault[0].equals(true)) {
//			dictMap.put(select_key, "请选择");
//		}
//		// dictMap.putAll(SpringContext.getDictInfo(dictCode));
//		dictMap.putAll(MetadataService.queryDictSub(dictCode, exchangeId));
//		return dictMap;
//	}
//
//	/**
//	 * @Title: getIncludeDics
//	 * @Description: (获取缓存信息)
//	 * @author huangfei19032@hundsun.com
//	 * @param @param dictCode
//	 * @param @return    设定文件
//	 * @return Map<String,String>    返回类型
//	 * @throws
//	 */
//	protected Map<String, String> getIncludeDics(int dictCode) {
//		Map<String, String> opMap = this.putSelectOption(dictCode, false);
//		return opMap;
//	}
//
//	/**
//	 * 放置下拉选项，包括默认选项：key=""，value="请选择"
//	 * 
//	 * @param dictCode
//	 * @param modelKey
//	 * @param model
//	 * @param hasDefault 是否需要默认下拉框 空和true表示需要，false表示不需要
//	 */
//	protected void putSelectOption(int dictCode, String modelKey, Model model, Boolean... hasDefault) {
//		if (hasDefault == null || hasDefault.length < 1 || hasDefault[0].equals(true)) {
//			model.addAttribute(modelKey, this.putSelectOption(dictCode, true));
//		} else {
//			model.addAttribute(modelKey, this.putSelectOption(dictCode, false));
//		}
//	}
//
//	/**
//	 * 放置下拉选项，包括默认选项：key=""，value="请选择"
//	 * 
//	 * @param dictCode
//	 * @param modelKey
//	 * @param model
//	 * @param hasDefault 是否需要默认下拉框 空和true表示需要，false表示不需要
//	 */
//	protected void putSelectOption(int dictCode, String exchangeId, String modelKey, Model model, Boolean... hasDefault) {
//		if (hasDefault == null || hasDefault.length < 1 || hasDefault[0].equals(true)) {
//			model.addAttribute(modelKey, this.putSelectOption(dictCode, exchangeId, true));
//		} else {
//			model.addAttribute(modelKey, this.putSelectOption(dictCode, exchangeId, false));
//		}
//	}
//
//	/**
//	 * 放置下拉选项，包括默认选项：key=""，value="请选择" include为指定的选项值
//	 * 
//	 * @param dictCode
//	 * @param modelKey
//	 * @param model
//	 * @param include
//	 */
//	protected void putSelectOption(int dictCode, String modelKey, Model model, String[] include) {
//		Map<String, String> opMap = this.putSelectOption(dictCode);
//		if (include != null) {
//			final List<String> asList = Arrays.asList(include);
//			opMap = Maps.filterKeys(opMap, new Predicate<String>() {
//				@Override
//				public boolean apply(String arg0) {
//					if (asList.contains(arg0) || select_key.equals(StringUtils.trimToEmpty(arg0))) {
//						return true;
//					}
//					return false;
//				}
//			});
//		}
//		model.addAttribute(modelKey, opMap);
//	}
//
//	/**
//	 * @param dictCode
//	 *            字典编号
//	 * @param modelKey
//	 * @param model
//	 * @param include
//	 * @param isInclude
//	 *            true-包含项；false-去除项
//	 * */
//	protected void putSelectOption(int dictCode, String modelKey, Model model, String[] include, boolean isInclude) {
//		if (isInclude) {
//			this.putSelectOption(dictCode, modelKey, model, include);
//		} else {
//			Map<String, String> opMap = this.putSelectOption(dictCode);
//			final List<String> asList = Arrays.asList(include);
//			Set<String> keyset = opMap.keySet();
//			Iterator<String> it = keyset.iterator();
//			while (it.hasNext()) {
//				String key = it.next();
//				for (String asKey : asList) {
//					if (com.hundsun.hitop.base.utils.StringUtils.equals(key, asKey)) {
//						it.remove();
//					}
//				}
//			}
//			model.addAttribute(modelKey, opMap);
//			// opMap = Maps.filterKeys(opMap, new Predicate<String>() {
//			// @Override
//			// public boolean apply(String arg0) {
//			// if (asList.contains(arg0)) {
//			// return false;
//			// }
//			// return true;
//			// }
//			// });
//		}
//	}
//	
//	
//	/**
//	 * 放置下拉选项（不包含默认选项）
//	 *  include为指定的选项值
//	 * 
//	 * @param dictCode
//	 * @param modelKey
//	 * @param model
//	 * @param include
//	 */
//	protected void putSelectOptionNoDefault(int dictCode, String modelKey, Model model, String[] include) {
//		Map<String, String> opMap = this.putSelectOption(dictCode,false);
//		if (include != null) {
//			final List<String> asList = Arrays.asList(include);
//			opMap = Maps.filterKeys(opMap, new Predicate<String>() {
//				@Override
//				public boolean apply(String arg0) {
//					if (asList.contains(arg0) || select_key.equals(StringUtils.trimToEmpty(arg0))) {
//						return true;
//					}
//					return false;
//				}
//			});
//		}
//		model.addAttribute(modelKey, opMap);
//	}
//
//	/**
//	 * 不包含默认选项
//	 * @param dictCode
//	 *            字典编号
//	 * @param modelKey
//	 * @param model
//	 * @param include
//	 * @param isInclude
//	 *            true-包含项；false-去除项
//	 * */
//	protected void putSelectOptionNoDefault(int dictCode, String modelKey, Model model, String[] include,boolean isInclude) {
//		if (isInclude) {
//			this.putSelectOptionNoDefault(dictCode, modelKey, model, include);
//		} else {
//			Map<String, String> opMap = this.putSelectOption(dictCode,false);
//			final List<String> asList = Arrays.asList(include);
//			Set<String> keyset = opMap.keySet();
//			Iterator<String> it = keyset.iterator();
//			while (it.hasNext()) {
//				String key = it.next();
//				for (String asKey : asList) {
//					if (com.hundsun.hitop.base.utils.StringUtils.equals(key, asKey)) {
//						it.remove();
//					}
//				}
//			}
//			model.addAttribute(modelKey, opMap);
//		}
//	}
//
//	/**
//	 * 获取指定字典项的编码
//	 * 
//	 * @param model
//	 * @param modelKey
//	 * @return
//	 */
//	protected List<String> getIncludeDics(Model model, String modelKey) {
//		List<String> lists = new ArrayList<String>();
//		@SuppressWarnings("unchecked")
//		Map<String, String> map = (Map<String, String>) model.asMap().get(modelKey);
//		if (map != null) {
//			Set<String> keys = map.keySet();
//			for (String key : keys) {
//				if (StringUtils.trimToNull(key) != null) {
//					lists.add(key);
//				}
//			}
//		}
//		return lists;
//	}
//
//	/**获取缓存service*/
//	public SysCacheService getSysCacheService() {
//		return SpringContext.getBean("sysCacheService", SysCacheService.class);
//	}
//
//	/**获取当前请求的用户信息*/
//	protected UserAgent getUserAgent(HttpServletRequest request) {
//		UserAgent userAgent = null;
//		// String clientIp = LoginUtils.getIpAddr(request);
//		String userAgentKey = CacheNameConstants.USER_AGENT_CACHEKEY/* + LoginUtils.getAuthUuid(request) */;
//		userAgent = getSysCacheService().getSessionObject(userAgentKey, UserAgent.class);
//		if (userAgent == null) {
//			LOG.error("UserAgent为空，请修复！");
//			userAgent = new UserAgent();
//		}
//		return userAgent;
//	}
//
//	/**
//	 * 获取所有交易所中文名
//	 */
//	protected Map<String, String> getExchangeInfoName() {
//		Map<String, ExchangeInfo> map = MetadataService.queryExchangeInfo();
//		Map<String, String> exchangeInfoNameMap = new HashMap<String, String>();
//		exchangeInfoNameMap.put("", "请选择");
//		for (String key : map.keySet()) {
//			exchangeInfoNameMap.put(key, map.get(key).getExchangeCnName());
//		}
//		return exchangeInfoNameMap;
//	}
//
//	/**
//	 * 获取所有交易所接入码
//	 */
//	protected Map<String, String> getExchangeAccessCode() {
//		Map<String, ExchangeInfo> map = MetadataService.queryExchangeInfo();
//		Map<String, String> exchangeAccessCodeMap = new HashMap<String, String>();
//		for (String key : map.keySet()) {
//			exchangeAccessCodeMap.put(key, map.get(key).getExchangeAccessCode());
//		}
//		return exchangeAccessCodeMap;
//	}
//
//	/**获取当前请求的用户信息*/
//	protected UserAgent getUserAgent() {
//		// HttpServletRequest request =
//		// ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//		UserAgent userAgent = null;
//		// String clientIp = LoginUtils.getIpAddr(request);
//		String userAgentKey = CacheNameConstants.USER_AGENT_CACHEKEY/* + LoginUtils.getAuthUuid(request) */;
//		userAgent = getSysCacheService().getSessionObject(userAgentKey, UserAgent.class);
//		if (userAgent == null) {
//			LOG.error("UserAgent为空，请修复！");
//			userAgent = new UserAgent();
//		}
//		return userAgent;
//	}
//
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		// binder.registerCustomEditor(String.class, new
//		// StringEscapeEditor(true, true, true));
//	}
//
//	/**
//	 * 
//	 * 方法作用：根据页面提交的Key对比Token的Value是否一致
//	 * 适用条件：防止页面重复提交，主要是防止截获请求恶意重复提交
//	 * @param req
//	 * @param resp
//	 * @return
//	 */
//	protected boolean checkRequestTokenValue(BaseReq req, BaseResp resp) {
//		TokenCache token = TokenCacheService.getToken(req.getTokenKey());
//		if (token == null) {
//			resp.setErrorNo(ErrorNoConstants.ERR_SYS_ILLEGITMACY_SUBMIT_REQUEST);// 提交的TokenKey错误
//			return false;
//		}
//
//		// 当token不为Null时，说明缓存有该Token,则先删除缓存该Token
//		TokenCacheService.removeToken(req.getTokenKey());
//		if (req.getTokenValue() != null && !req.getTokenValue().equals(token.getTokenValue())) {
//			resp.setErrorNo(ErrorNoConstants.ERR_SYS_ILLEGITMACY_SUBMIT_REQUEST);// 提交的TokenValue错误
//			return false;
//		}
//		//给相关字段加密比对
//		String hiddenSecretParams = req.getHiddenSecretParams();
//		if(StringUtils.isNotEmpty(hiddenSecretParams) && hiddenSecretParams.indexOf("#")!=-1){
//			String[] paramArray = hiddenSecretParams.split("#");
//			String[] attrsArray = paramArray[0].split(",");
//			//获取类中加载了@Valid注解的属性
//			Object obj =ReflectUtils.getFieldByValidAnnotation(req);
//
//			List<String> results=new ArrayList<String>();
//			
//			for(int k=0;k<attrsArray.length;k++){
//				if(StringUtils.isEmpty(String.valueOf(attrsArray[k]))){
//					results.add("");
//					continue;
//				}
//				Object fieldValue = ReflectUtils.execGetMethod(obj, attrsArray[k]);
//				results.add(fieldValue==null?"":fieldValue.toString());
//			}
//			try {
//				String encryptresult =  EncryptUtils.encrypt(EncryptUtils.join(",", results));
//				if(StringUtils.isEmpty(encryptresult)){
//					resp.setErrorNo(ErrorNoConstants.ERR_COM_ERRORINFO,"非法提交的数据，隐藏域数据被篡改");
//					return false;
//				}
//				if(!encryptresult.equals(paramArray[1])){
//					resp.setErrorNo(ErrorNoConstants.ERR_COM_ERRORINFO,"非法提交的数据，隐藏域数据被篡改");
//					return false;
//				}
//			} catch (Exception e) {
//				resp.setErrorNo(ErrorNoConstants.ERR_COM_ERRORINFO,"非法提交的数据，隐藏域数据被篡改");
//				return false;
//			}
//		}
//		return true;
//	}
}