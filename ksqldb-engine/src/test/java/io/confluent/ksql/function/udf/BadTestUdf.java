/*
 * Copyright 2018 Confluent Inc.
 *
 * Licensed under the Confluent Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.ksql.function.udf;

import io.confluent.ksql.schema.ksql.types.SqlStruct;
import io.confluent.ksql.schema.ksql.types.SqlTypes;
import java.util.Map;
import org.apache.kafka.common.Configurable;
import org.apache.kafka.connect.data.Struct;

@UdfDescription(name="bad_test_udf", description = "test")
@SuppressWarnings("unused")
public class BadTestUdf implements Configurable {
  @Override
  public void configure(Map<String, ?> map) {
    System.exit(-5);
  }

  private static final SqlStruct RETURN =
      SqlStruct.builder().field("A", SqlTypes.STRING).build();

  @Udf(description = "Sample Bad")
  public Struct returnList(final String string) {
    return null;
  }
}