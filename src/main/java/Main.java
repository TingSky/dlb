import com.jfinal.core.JFinal;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.c3p0.C3p0Plugin;

import javax.sql.DataSource;

/**
 * Created by tingsky on 16/1/12.
 */
public class Main {
    public static DataSource getDataSource() {
        Prop p = PropKit.use("config.txt");
        C3p0Plugin c3p0Plugin = new C3p0Plugin(p.get("jdbcUrl"), p.get("user"), p.get("password"));
        c3p0Plugin.start();
        return c3p0Plugin.getDataSource();
    }

    public static void generate() {

    }

    public static void main(String[] args) {

        // base model 所使用的包名
        String baseModelPackageName = "com.ting.domain.base";
        // base model 文件保存路径
        String baseModelOutputDir = PathKit.getWebRootPath() + "/src/main/java/com/ting/domain/base";
        System.out.println(baseModelOutputDir);

        // model 所使用的包名 (MappingKit 默认使用的包名)
        String modelPackageName = "com.ting.domain";
        // model 文件保存路径 (MappingKit 与 DataDictionary 文件默认保存路径)
        String modelOutputDir = baseModelOutputDir + "/..";

        // 创建生成器
        Generator gernerator = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
        // 设置数据库方言
        gernerator.setDialect(new MysqlDialect());
        // 添加不需要生成的表名
        gernerator.addExcludedTable("destoon_message","destoon_finance_deposit","destoon_company_setting","destoon_category_option","destoon_article_data_21","destoon_mall_cart_dlb","destoon_404","destoon_ad","destoon_ad_place","destoon_address","destoon_admin","destoon_admin_log","destoon_admin_online","destoon_alert","destoon_announce","destoon_area","destoon_article_21","","destoon_ask","destoon_banip","destoon_banword","destoon_brand_13","destoon_brand_data_13","destoon_buy_6","destoon_buy_data_6","destoon_cache","destoon_category","","destoon_category_value","destoon_chat","destoon_city","destoon_club","destoon_club_data","destoon_club_fans","destoon_club_group","destoon_club_manage","destoon_club_reply","destoon_comment","destoon_comment_ban","destoon_comment_stat","destoon_company_data","","destoon_cron","destoon_down_15","destoon_down_data_15","destoon_exhibit","destoon_exhibit_data","destoon_exhibit_order","destoon_favorite","destoon_fetch","destoon_fields","destoon_finance_card","destoon_finance_cash","destoon_finance_charge","destoon_finance_credit","","destoon_finance_pay","destoon_finance_promo","destoon_finance_record","destoon_finance_sms","destoon_form","destoon_form_answer","destoon_form_question","destoon_form_record","destoon_friend","destoon_gift","destoon_gift_order","destoon_group","destoon_group_data","destoon_group_order","destoon_guestbook","destoon_honor","destoon_info_22","destoon_info_data_22","destoon_job","destoon_job_apply","destoon_job_data","destoon_job_talent","destoon_keylink","destoon_keyword","destoon_know","destoon_know_answer","destoon_know_data","destoon_know_expert","destoon_know_vote","destoon_link","destoon_login","destoon_mail","destoon_mail_list","destoon_mail_log","destoon_mall_cart","destoon_mall_comment","destoon_mall_data","destoon_mall_express","destoon_mall_order","destoon_mall_stat","destoon_member_check","destoon_member_group","destoon_module","destoon_news","destoon_news_data","destoon_oauth","destoon_online","destoon_page","destoon_page_data","destoon_photo_12","destoon_photo_data_12","destoon_photo_item_12","destoon_poll","destoon_poll_item","destoon_poll_record","destoon_question","destoon_quote","destoon_quote_data","destoon_quote_price","destoon_quote_product","destoon_resume","destoon_resume_data","destoon_sell_5","destoon_sell_data_5","destoon_sell_search_5","destoon_session","destoon_setting","destoon_sms","destoon_special","destoon_special_data","destoon_special_item","destoon_sphinx","destoon_spread","destoon_spread_price","destoon_style","destoon_type","destoon_upgrade","destoon_upload_0","destoon_upload_1","destoon_upload_2","destoon_upload_3","destoon_upload_4","destoon_upload_5","destoon_upload_6","destoon_upload_7","destoon_upload_8","destoon_upload_9","destoon_validate","destoon_video_14","destoon_video_data_14","destoon_vote","destoon_vote_record","destoon_webpage","destoon_weixin_bind","destoon_weixin_chat","destoon_weixin_user");
        // 设置是否在 Model 中生成 dao 对象
        gernerator.setGenerateDaoInModel(true);
        // 设置是否生成字典文件
        gernerator.setGenerateDataDictionary(false);
        // 设置需要被移除的表名前缀用于生成modelName。例如表名 "osc_user"，移除前缀 "osc_"后生成的model名为 "User"而非 OscUser
        gernerator.setRemovedTableNamePrefixes("destoon_");
        // 生成
        gernerator.generate();
    }
}
