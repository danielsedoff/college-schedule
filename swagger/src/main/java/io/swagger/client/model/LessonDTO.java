/**
 * Spring Boot REST API
 * \"Spring Boot REST API for the College Schedule Web App\"
 *
 * OpenAPI spec version: 0.1
 * Contact: sedoff@zohomail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * LessonDTO
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-11T16:48:00.567+04:00")
public class LessonDTO   {
  @SerializedName("endTime")
  private String endTime = null;

  @SerializedName("groupId")
  private Integer groupId = null;

  @SerializedName("id")
  private Integer id = null;

  @SerializedName("mode")
  private String mode = null;

  @SerializedName("professorId")
  private Integer professorId = null;

  @SerializedName("startTime")
  private String startTime = null;

  public LessonDTO endTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

   /**
   * Get endTime
   * @return endTime
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public LessonDTO groupId(Integer groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * Get groupId
   * @return groupId
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getGroupId() {
    return groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public LessonDTO id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LessonDTO mode(String mode) {
    this.mode = mode;
    return this;
  }

   /**
   * Get mode
   * @return mode
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public LessonDTO professorId(Integer professorId) {
    this.professorId = professorId;
    return this;
  }

   /**
   * Get professorId
   * @return professorId
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getProfessorId() {
    return professorId;
  }

  public void setProfessorId(Integer professorId) {
    this.professorId = professorId;
  }

  public LessonDTO startTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
   * Get startTime
   * @return startTime
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LessonDTO lessonDTO = (LessonDTO) o;
    return Objects.equals(this.endTime, lessonDTO.endTime) &&
        Objects.equals(this.groupId, lessonDTO.groupId) &&
        Objects.equals(this.id, lessonDTO.id) &&
        Objects.equals(this.mode, lessonDTO.mode) &&
        Objects.equals(this.professorId, lessonDTO.professorId) &&
        Objects.equals(this.startTime, lessonDTO.startTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endTime, groupId, id, mode, professorId, startTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LessonDTO {\n");
    
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    professorId: ").append(toIndentedString(professorId)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

