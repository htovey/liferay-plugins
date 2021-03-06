/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.twitter.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.twitter.model.Feed;
import com.liferay.twitter.model.FeedModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Feed service. Represents a row in the &quot;Twitter_Feed&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.twitter.model.FeedModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FeedImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeedImpl
 * @see com.liferay.twitter.model.Feed
 * @see com.liferay.twitter.model.FeedModel
 * @generated
 */
public class FeedModelImpl extends BaseModelImpl<Feed> implements FeedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a feed model instance should use the {@link com.liferay.twitter.model.Feed} interface instead.
	 */
	public static final String TABLE_NAME = "Twitter_Feed";
	public static final Object[][] TABLE_COLUMNS = {
			{ "feedId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "twitterUserId", Types.BIGINT },
			{ "twitterScreenName", Types.VARCHAR },
			{ "lastStatusId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Twitter_Feed (feedId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,twitterUserId LONG,twitterScreenName VARCHAR(75) null,lastStatusId LONG)";
	public static final String TABLE_SQL_DROP = "drop table Twitter_Feed";
	public static final String ORDER_BY_JPQL = " ORDER BY feed.feedId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Twitter_Feed.feedId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.twitter.model.Feed"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.twitter.model.Feed"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.twitter.model.Feed"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long TWITTERSCREENNAME_COLUMN_BITMASK = 2L;
	public static long TWITTERUSERID_COLUMN_BITMASK = 4L;
	public static long FEEDID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.twitter.model.Feed"));

	public FeedModelImpl() {
	}

	public long getPrimaryKey() {
		return _feedId;
	}

	public void setPrimaryKey(long primaryKey) {
		setFeedId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _feedId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Feed.class;
	}

	public String getModelClassName() {
		return Feed.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("feedId", getFeedId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("twitterUserId", getTwitterUserId());
		attributes.put("twitterScreenName", getTwitterScreenName());
		attributes.put("lastStatusId", getLastStatusId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long feedId = (Long)attributes.get("feedId");

		if (feedId != null) {
			setFeedId(feedId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long twitterUserId = (Long)attributes.get("twitterUserId");

		if (twitterUserId != null) {
			setTwitterUserId(twitterUserId);
		}

		String twitterScreenName = (String)attributes.get("twitterScreenName");

		if (twitterScreenName != null) {
			setTwitterScreenName(twitterScreenName);
		}

		Long lastStatusId = (Long)attributes.get("lastStatusId");

		if (lastStatusId != null) {
			setLastStatusId(lastStatusId);
		}
	}

	public long getFeedId() {
		return _feedId;
	}

	public void setFeedId(long feedId) {
		_feedId = feedId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getTwitterUserId() {
		return _twitterUserId;
	}

	public void setTwitterUserId(long twitterUserId) {
		_columnBitmask |= TWITTERUSERID_COLUMN_BITMASK;

		if (!_setOriginalTwitterUserId) {
			_setOriginalTwitterUserId = true;

			_originalTwitterUserId = _twitterUserId;
		}

		_twitterUserId = twitterUserId;
	}

	public String getTwitterUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getTwitterUserId(), "uuid",
			_twitterUserUuid);
	}

	public void setTwitterUserUuid(String twitterUserUuid) {
		_twitterUserUuid = twitterUserUuid;
	}

	public long getOriginalTwitterUserId() {
		return _originalTwitterUserId;
	}

	public String getTwitterScreenName() {
		if (_twitterScreenName == null) {
			return StringPool.BLANK;
		}
		else {
			return _twitterScreenName;
		}
	}

	public void setTwitterScreenName(String twitterScreenName) {
		_columnBitmask |= TWITTERSCREENNAME_COLUMN_BITMASK;

		if (_originalTwitterScreenName == null) {
			_originalTwitterScreenName = _twitterScreenName;
		}

		_twitterScreenName = twitterScreenName;
	}

	public String getOriginalTwitterScreenName() {
		return GetterUtil.getString(_originalTwitterScreenName);
	}

	public long getLastStatusId() {
		return _lastStatusId;
	}

	public void setLastStatusId(long lastStatusId) {
		_lastStatusId = lastStatusId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Feed.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Feed toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Feed)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FeedImpl feedImpl = new FeedImpl();

		feedImpl.setFeedId(getFeedId());
		feedImpl.setCompanyId(getCompanyId());
		feedImpl.setUserId(getUserId());
		feedImpl.setUserName(getUserName());
		feedImpl.setCreateDate(getCreateDate());
		feedImpl.setModifiedDate(getModifiedDate());
		feedImpl.setTwitterUserId(getTwitterUserId());
		feedImpl.setTwitterScreenName(getTwitterScreenName());
		feedImpl.setLastStatusId(getLastStatusId());

		feedImpl.resetOriginalValues();

		return feedImpl;
	}

	public int compareTo(Feed feed) {
		long primaryKey = feed.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Feed feed = null;

		try {
			feed = (Feed)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = feed.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		FeedModelImpl feedModelImpl = this;

		feedModelImpl._originalCompanyId = feedModelImpl._companyId;

		feedModelImpl._setOriginalCompanyId = false;

		feedModelImpl._originalTwitterUserId = feedModelImpl._twitterUserId;

		feedModelImpl._setOriginalTwitterUserId = false;

		feedModelImpl._originalTwitterScreenName = feedModelImpl._twitterScreenName;

		feedModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Feed> toCacheModel() {
		FeedCacheModel feedCacheModel = new FeedCacheModel();

		feedCacheModel.feedId = getFeedId();

		feedCacheModel.companyId = getCompanyId();

		feedCacheModel.userId = getUserId();

		feedCacheModel.userName = getUserName();

		String userName = feedCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			feedCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			feedCacheModel.createDate = createDate.getTime();
		}
		else {
			feedCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			feedCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			feedCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		feedCacheModel.twitterUserId = getTwitterUserId();

		feedCacheModel.twitterScreenName = getTwitterScreenName();

		String twitterScreenName = feedCacheModel.twitterScreenName;

		if ((twitterScreenName != null) && (twitterScreenName.length() == 0)) {
			feedCacheModel.twitterScreenName = null;
		}

		feedCacheModel.lastStatusId = getLastStatusId();

		return feedCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{feedId=");
		sb.append(getFeedId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", twitterUserId=");
		sb.append(getTwitterUserId());
		sb.append(", twitterScreenName=");
		sb.append(getTwitterScreenName());
		sb.append(", lastStatusId=");
		sb.append(getLastStatusId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.twitter.model.Feed");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>feedId</column-name><column-value><![CDATA[");
		sb.append(getFeedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitterUserId</column-name><column-value><![CDATA[");
		sb.append(getTwitterUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitterScreenName</column-name><column-value><![CDATA[");
		sb.append(getTwitterScreenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastStatusId</column-name><column-value><![CDATA[");
		sb.append(getLastStatusId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Feed.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Feed.class };
	private long _feedId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _twitterUserId;
	private String _twitterUserUuid;
	private long _originalTwitterUserId;
	private boolean _setOriginalTwitterUserId;
	private String _twitterScreenName;
	private String _originalTwitterScreenName;
	private long _lastStatusId;
	private long _columnBitmask;
	private Feed _escapedModel;
}