package com.card.game.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.card.game.api.user.dto.AvatarDTO;
import com.card.game.common.web.utils.NameUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author tom
 * @since 2023-01-08
 */
@Getter
@Setter
@TableName("sys_user")
@ApiModel(value = "SysUserEntity对象", description = "")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("性别((1:男;0:女,2:未知))")
    private Integer gender;

    @ApiModelProperty("头像信息")
    private String avatar;

    @ApiModelProperty("城市")
    private String country;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime updateTime;

    @ApiModelProperty("创建者")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String createBy;

    @ApiModelProperty("更新人")
    @TableField(fill = FieldFill.INSERT)
    private String updateBy;

    @ApiModelProperty("0-正常，1-锁定")
    private Boolean lockFlag;

    @ApiModelProperty("0-正常，1-删除")
    @TableLogic
    private Integer delFlag;



    /**
     * 构建默认的用户信息
     *
     * @return SysUserEntity
     */
    public static SysUserEntity buildDefaultUser() {
        String name = NameUtil.getNickName();
        return SysUserEntity.builder()
                .nickname(name)
                .gender(2)
                .lockFlag(false)
                .build();
    }

    public void buildAvatarInfo(SysImageInfoEntity avatar) {
        setAvatar(avatar.getSrc());
        setCountry(avatar.getCountry());
    }

    public void buildAvatarInfo(AvatarDTO avatar) {
        setAvatar(avatar.getUrl());
        setCountry(avatar.getCountry());
    }
}
